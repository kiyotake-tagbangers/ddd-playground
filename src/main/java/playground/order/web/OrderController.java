package playground.order.web;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.support.SelfLinkProvider;
import org.springframework.data.rest.webmvc.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.UriTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import playground.order.CreateOrder;
import playground.order.OrderService;

import java.util.Optional;

/**
 * @author KOGA, Yu
 */
@RepositoryRestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final HttpHeadersPreparer headersPreparer;

    private final SelfLinkProvider linkProvider;

    private final RepositoryRestConfiguration restConfiguration;

    @PostMapping
    public ResponseEntity<RepresentationModel<?>> create(
            @RequestBody CreateOrder command,
            @RequestHeader(value = "Accept", required = false) String acceptHeader,
            PersistentEntityResourceAssembler assembler) throws NotFoundException {
        var order = this.orderService.createOrder(command);

        Optional<PersistentEntityResource> resource = Optional
                .ofNullable(this.restConfiguration.returnBodyOnCreate(acceptHeader)
                        ? assembler.toFullResource(order) : null);
        HttpHeaders headers = this.headersPreparer.prepareHeaders(resource);
        String selfLink = this.linkProvider.createSelfLinkFor(order).withSelfRel().expand().getHref();
        headers.setLocation(UriTemplate.of(selfLink).expand());

        return ControllerUtils.toResponseEntity(HttpStatus.CREATED, headers, resource);
    }
}

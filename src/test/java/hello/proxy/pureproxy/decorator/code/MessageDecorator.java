package hello.proxy.pureproxy.decorator.code;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MessageDecorator implements Component {

    private final Component component;

    @Override
    public String operation() {

        log.info("MessageDecorator 실행");
        String operation = component.operation();
        String decoResult = "*****" + operation + "*****";
        log.info("MessageDecorator 꾸미기 적용 전={}, 적용 후={}", operation, decoResult);
        return decoResult;
    }
}

package hello.proxy.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceImpl implements ServiceInterface {

    private static final Logger log = LoggerFactory.getLogger(ServiceImpl.class);

    @Override
    public void save() {
        log.info("save 호출");
    }

    @Override
    public void find() {
        log.info("find 호출");
    }
}

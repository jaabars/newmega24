package kg.megacom.mega24.services.impl;

import kg.megacom.mega24.dao.SubscriberRep;
import kg.megacom.mega24.mappers.SubscriberMapper;
import kg.megacom.mega24.models.dto.SubscriberDto;
import kg.megacom.mega24.models.entity.Subscriber;
import kg.megacom.mega24.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    private SubscriberMapper subscriberMapper = SubscriberMapper.INSTANCE;

    @Autowired
    private SubscriberRep subscriberRep;

    @Override
    public SubscriberDto findSubsByPhone(String phoneNum) {
        Subscriber subscriber = subscriberRep.findByPhoneNumber(phoneNum);

        return subscriber == null ? null : subscriberMapper.toSubscriberDto(subscriber);
    }

    @Override
    public SubscriberDto saveSubscriber(String phoneNumber) {
        Subscriber subscriber = new Subscriber();
        subscriber.setPhoneNumber(phoneNumber);
        subscriber = subscriberRep.save(subscriber);
        return SubscriberMapper.INSTANCE.toSubscriberDto(subscriber);
    }
}

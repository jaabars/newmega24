package kg.megacom.mega24.services;

import kg.megacom.mega24.models.dto.SubscriberDto;

public interface SubscriberService {

    SubscriberDto findSubsByPhone(String phoneNum);
    SubscriberDto saveSubscriber(String phoneNumber);
}

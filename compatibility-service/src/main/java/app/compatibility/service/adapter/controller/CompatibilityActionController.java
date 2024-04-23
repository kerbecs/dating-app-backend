package app.compatibility.service.adapter.controller;

import app.compatibility.service.adapter.client.NotificationClient;
import app.compatibility.service.application.dto.CompatibilityActionDto;
import app.compatibility.service.application.dto.NotificationDto;
import app.compatibility.service.application.helper.UserMatchAction;
import app.compatibility.service.application.mapper.NotificationMapper;
import app.compatibility.service.port.facade.CompatibilityActionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/compatibility")
@RequiredArgsConstructor
public class CompatibilityActionController {
    private final CompatibilityActionFacade facade;
    private final NotificationClient notificationClient;
    private final NotificationMapper notificationMapper;
    @GetMapping("/{senderId}/{receiverId}")
    public List<CompatibilityActionDto> findAllBySenderIdAndReceiverId(@PathVariable Long senderId,@PathVariable Long receiverId) {
        return facade.findAllBySenderIdAndReceiverId(senderId, receiverId);
    }
    @PostMapping("/all/{receiverId}/{userMatchAction}")
    public Integer countAllByReceiverIdAndUserMatchAction(@PathVariable Long receiverId,@PathVariable UserMatchAction userMatchAction) {
        return facade.countAllByReceiverIdAndUserMatchAction(receiverId, userMatchAction);
    }
    @PostMapping
    public CompatibilityActionDto saveCompatibilityAction(@RequestBody CompatibilityActionDto compatibilityActionDto){
        compatibilityActionDto.setTime(LocalDateTime.now());
        NotificationDto notificationDto = notificationMapper.compatibilityActionDtoToNotificationDto(compatibilityActionDto);
        notificationDto.setRead(false);

        System.out.println(notificationDto);

        notificationClient.sendNotification(notificationDto);

        return facade.saveCompatibilityAction(compatibilityActionDto);
    }
}

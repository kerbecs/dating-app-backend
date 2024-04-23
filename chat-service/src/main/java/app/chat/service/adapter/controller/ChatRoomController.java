package app.chat.service.adapter.controller;

import app.chat.service.application.dto.ChatRoomDto;
import app.chat.service.application.mapper.ChatRoomMapper;
import app.chat.service.port.facade.ChatRoomFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/chat-room")
public class ChatRoomController {
    private final ChatRoomFacade chatRoomFacade;
    private final ChatRoomMapper chatRoomMapper;

    @PostMapping
    public ChatRoomDto saveChatRoom(@RequestBody ChatRoomDto chatRoomDto){
        return chatRoomMapper.chatRoomToChatRoomDto(chatRoomMapper.chatRoomDtoToChatRoom(chatRoomFacade.saveChatRoom(chatRoomDto)));
    }

}

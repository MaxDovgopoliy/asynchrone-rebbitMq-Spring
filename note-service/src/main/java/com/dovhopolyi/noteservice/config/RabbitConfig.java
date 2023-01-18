package com.dovhopolyi.noteservice.config;

import com.dovhopolyi.noteservice.dto.UpdateEntity;
import com.dovhopolyi.noteservice.service.PersonClientService;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitConfig {
    private final PersonClientService personClientService;
    @Bean
    public Consumer<UpdateEntity> personUpdateConsumer() {
        return event-> personClientService.SynchronizePersonById(event.getId());
    }
}

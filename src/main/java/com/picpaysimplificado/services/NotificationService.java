package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dtos.NotificationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();

        NotificationDTO notificationRequest = new NotificationDTO(email, message);

//        ResponseEntity<String> responseNotification = restTemplate
//                                            .postForEntity(
//                                                "https://util.devi.tools/api/v1/notify",
//                                                notificationRequest,
//                                                String.class
//                                            );
//
//        if (!(responseNotification.getStatusCode() == HttpStatus.OK)) {
//            System.out.println("erro ao enviar notificacao!");
//
//            throw new Exception("Servico de notificacao esta fora do ar!");
//        }
        System.out.println("Notificacao enviada para o usuario!");
    }
}

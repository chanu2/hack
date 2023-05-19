package gdschack.server.service;

import gdschack.server.domain.Participation;
import gdschack.server.domain.User;
import gdschack.server.dto.request.CreateParticipationDto;
import gdschack.server.dto.response.ParticipationListDto;
import gdschack.server.repository.ParticipationRepository;
import gdschack.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParticipationService {

    private final ParticipationRepository participationRepository;
    private final UserRepository userRepository;

    public void createParticipation(CreateParticipationDto createParticipationDto){

        User user = userRepository.findByLoginId(createParticipationDto.getLoginId()).get();

        Participation participation = Participation.builder()
                .user(user)
                .teacherLoginId(createParticipationDto.getTeacherLoginId())
                .build();

        participationRepository.save(participation);

    }

    public void deleteParticipation(){

    }

    public List<ParticipationListDto> participationList(String teacherLoginId){
        List<Participation> participations = participationRepository.findAllByTeacherLoginId(teacherLoginId);
        return participations.stream().map(participation -> new ParticipationListDto(participation)).collect(Collectors.toList());
    }
}

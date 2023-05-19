package gdschack.server.controller;


import gdschack.server.dto.request.CreateParticipationDto;
import gdschack.server.dto.response.ParticipationListDto;
import gdschack.server.service.ParticipationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/participation")
public class ParticipationController {

    private final ParticipationService participationService;

    @PostMapping("/create")
    public void createParticipation(@RequestBody CreateParticipationDto createParticipationDto){
        participationService.createParticipation(createParticipationDto);

    }

    @PostMapping("/delete")
    public void deleteParticipation(){

    }

    @GetMapping("/list/{teacherLoginId}")
    public List<ParticipationListDto> participationList(@PathVariable String teacherLoginId){
        return participationService.participationList(teacherLoginId);
    }



}

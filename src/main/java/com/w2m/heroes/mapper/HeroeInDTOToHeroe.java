package com.w2m.heroes.mapper;

import com.w2m.heroes.persistence.entity.Heroe;
import com.w2m.heroes.services.dto.HeroeInDTO;
import org.springframework.stereotype.Component;

@Component
public class HeroeInDTOToHeroe implements IMapper<HeroeInDTO, Heroe>{
    @Override
    public Heroe map(HeroeInDTO in){
        Heroe heroe = new Heroe();
        heroe.setName(in.getName());
        heroe.setCampo1(in.getCampo1());
        heroe.setCampo2(in.getCampo2());
        heroe.setCampo3(in.getCampo3());
        heroe.setStatus(in.getStatus());
        return heroe;
    }

}

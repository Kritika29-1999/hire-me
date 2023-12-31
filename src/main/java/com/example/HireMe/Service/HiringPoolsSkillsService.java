package com.example.HireMe.Service;

import com.example.HireMe.Model.HiringPoolSkills;
import com.example.HireMe.Model.HiringPools;
import com.example.HireMe.Repository.HiringPoolsSkillsRepository;
import com.example.HireMe.Repository.OrganisationHiringPoolsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HiringPoolsSkillsService {
    private HiringPoolsSkillsRepository hiringPoolsSkillsRepository;
    public HiringPoolsSkillsService (HiringPoolsSkillsRepository hiringPoolsSkillsRepository){
        this.hiringPoolsSkillsRepository = hiringPoolsSkillsRepository;
    }
    public void savehiringpoolsskills(HiringPoolSkills hiringPoolSkills){
        hiringPoolsSkillsRepository.save(hiringPoolSkills);
    }
    public List<HiringPoolSkills> getHiringPoolSkillsBypoolid(HiringPools poolId){
        return  hiringPoolsSkillsRepository.findHiringPoolSkillsByHiringpoolid(poolId);
    }
}

package com.example.HireMe.Repository;

import com.example.HireMe.Model.HiringPoolSkills;
import com.example.HireMe.Model.HiringPools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HiringPoolsSkillsRepository extends JpaRepository<HiringPoolSkills, Long> {
    List<HiringPoolSkills> findAll();
    List<HiringPoolSkills> findHiringPoolSkillsByHiringpoolid(HiringPools hiringPools);

}

package com.example.HireMe;

import com.example.HireMe.Model.Applicant;
import com.example.HireMe.Model.Organisation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.view.RedirectView;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Functions {
    public Applicant getApplicant(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Applicant Appid = new Applicant();
        Appid.setId(((Applicant) authentication.getPrincipal()).getId());
        return Appid;
    }
    public Organisation getOrganisation(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Organisation orgid = new Organisation();
        orgid.setId(((Organisation) authentication.getPrincipal()).getId());
        return orgid;
    }
    public Date getdate(){
        LocalDate localDate = LocalDate.now();

        // Convert LocalDate to Date
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }

}

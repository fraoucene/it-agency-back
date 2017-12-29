package com.it.agency.controllers;

import com.it.agency.beans.Mail;
import com.it.agency.services.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailRestController {

    private static Logger log = LoggerFactory.getLogger(EmailRestController.class);

    @Autowired
    private EmailService emailService;

    @Value("${mail.from}")
    private String from;

    @Value("${mail.to}")
    private String to;

    @Value("${mail.candidature.objet}")
    private String candidatureObjet;

    @Value("${mail.recrutement.objet}")
    private String recrutementObjet;

    @Value("${mail.information.objet}")
    private String informationObjet;

    @RequestMapping(path = "/condidature", method = RequestMethod.POST)
    public void sendCondidatureMail() {
        log.info("Spring Mail - Sending Email Candidature to " + to);

        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(candidatureObjet);
        mail.setContent("This tutorial demonstrates how to send a simple email using Spring Framework.");
        emailService.sendSimpleMessage(mail);
    }

    @RequestMapping(path = "/recrutement", method = RequestMethod.POST)
    public void sendRecreutmentMail() {
        log.info("Spring Mail - Sending Email Recrutement to " + to);

        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(recrutementObjet);
        mail.setContent("This tutorial demonstrates how to send a simple email using Spring Framework.");
        emailService.sendSimpleMessage(mail);
    }

    @RequestMapping(path = "/information", method = RequestMethod.POST)
    public void sendInformationMail() {
        log.info("Spring Mail - Sending Email Information to " + to);
        Mail mail = new Mail();
        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(informationObjet);
        mail.setContent("This tutorial demonstrates how to send a simple email using Spring Framework.");
        emailService.sendSimpleMessage(mail);
    }
}

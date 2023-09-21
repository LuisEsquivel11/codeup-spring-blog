package edu.codeup.codeupspringblog.services;

import edu.codeup.codeupspringblog.repositories.AdRepository;
import edu.codeup.codeupspringblog.repositories.ContactRepository;

public class CountSvc {

    private ContactRepository contactDao;
    private AdRepository adsDao;

    public CountSvc(ContactRepository contactDao, AdRepository adsDao){

    }
//    public long returnAdsContactsCount() {
//        return ""
//    }
}

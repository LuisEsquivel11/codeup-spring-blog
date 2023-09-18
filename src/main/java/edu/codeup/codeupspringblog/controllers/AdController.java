

import edu.codeup.codeupspringblog.models.Ad;
import edu.codeup.codeupspringblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdController {

    private AdRepository adsDao;

    public AdController(AdRepository adsDao) {
        this.adsDao = adsDao;
    }

    @GetMapping("/ads")
    @ResponseBody
    public List<Ad> returnAds() {
        return adsDao.findByOrderByTitle();
    }

    @GetMapping("/ads/{id}")
    @ResponseBody
    public Ad returnAd(@PathVariable Long id) {
        return adsDao.getAdById(id);
    }

}

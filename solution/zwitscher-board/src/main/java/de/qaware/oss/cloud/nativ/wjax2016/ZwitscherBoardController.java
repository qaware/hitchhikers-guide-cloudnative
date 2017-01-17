package de.qaware.oss.cloud.nativ.wjax2016;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * The main UI controller for the Zwitscher board interface.
 */
@Controller
public class ZwitscherBoardController {

    @Autowired
    private ZwitscherRepository zwitscherRepository;

    @Value("${board.title}")
    private String title;

    /**
     * Renders the one and only Zwitscher board UI.
     *
     * @param viewModel the view model used to render the template
     * @return the template to use
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model viewModel) {
        populateDefault(viewModel);
        return "index";
    }

    /**
     * Called when posting the search form on the Zwitscher board.
     *
     * @param q         the query string
     * @param viewModel the view model used to render the template
     * @return the template to use
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("q") @Length(max = 500) String q,
                         Model viewModel) {
        populateDefault(viewModel);
        populateTweets(q, viewModel);
        return "index";
    }

    private void populateDefault(Model viewModel) {
        viewModel.addAttribute("title", title);
    }


    private void populateTweets(String q, Model viewModel) {
        Collection<String> tweets = zwitscherRepository.findByQ(q);
        viewModel.addAttribute("tweets", tweets);
    }
}

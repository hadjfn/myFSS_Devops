package faria.sasikumar.sylla.myfss.controller;

import faria.sasikumar.sylla.myfss.client.StatsClient;
import faria.sasikumar.sylla.myfss.client.StatsSummary;
import faria.sasikumar.sylla.myfss.model.Apprenti;
import faria.sasikumar.sylla.myfss.service.ApprentiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class DashboardController {

    private final ApprentiService apprentiService;
    private final StatsClient statsClient;

    public DashboardController(ApprentiService apprentiService, StatsClient statsClient) {
        this.apprentiService = apprentiService;
        this.statsClient = statsClient;
    }

    @GetMapping({"/", "/dashboard"})
    public String dashboard(Model model, Principal principal) {
        List<Apprenti> apprentis = apprentiService.getAllApprentisNoArchived();
        StatsSummary stats = statsClient.fetchSummary(apprentiService.getAllApprentis());

        model.addAttribute("apprentis", apprentis);
        model.addAttribute("stats", stats);

        String username = (principal != null) ? principal.getName() : "Invité";
        model.addAttribute("username", username);

        return "dashboard";
    }
}

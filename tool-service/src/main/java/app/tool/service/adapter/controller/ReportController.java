package app.tool.service.adapter.controller;

import app.tool.service.application.helper.ReportReason;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {
    @GetMapping("/reason")
    public ReportReason[] getReportReasonList(){
        return ReportReason.values();
    }
}

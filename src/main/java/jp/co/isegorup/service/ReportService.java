package jp.co.isegorup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.isegorup.domain.ReportEntity;
import jp.co.isegorup.repository.ReportRepository;

@Service
public class ReportService {
    @Autowired
    ReportRepository reportRepository;

    public ReportEntity create(ReportEntity reportEntity) {
        reportRepository.save(reportEntity);
        return reportEntity;
    }

    public ReportEntity updateBasicSection(ReportEntity reportEntity) {
        reportRepository.save(reportEntity);
        return reportEntity;
    }

    public ReportEntity updateItemSummary(ReportEntity reportEntity) {
        reportRepository.save(reportEntity);
        return reportEntity;
    }

    public ReportEntity updateHazard(ReportEntity reportEntity) {
        reportRepository.save(reportEntity);
        return reportEntity;
    }

    public ReportEntity updatePharmacokinetics(ReportEntity reportEntity) {
        reportRepository.save(reportEntity);
        return reportEntity;
    }

    public ReportEntity updateItemRemarks(ReportEntity reportEntity) {
        reportRepository.save(reportEntity);
        return reportEntity;
    }

    public ReportEntity updateNotesSummary(ReportEntity reportEntity) {
        reportRepository.save(reportEntity);
        return reportEntity;
    }

    public List<ReportEntity> findAll() {
        List<ReportEntity> reportEntityList = new ArrayList<ReportEntity>();
        reportEntityList = reportRepository.findAll();
        return reportEntityList;
    }
}

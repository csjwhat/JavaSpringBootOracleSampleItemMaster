package jp.co.isegorup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.isegorup.domain.ReportEntity;

public interface ReportRepository extends JpaRepository<ReportEntity, Integer> {

    // セクション毎のUpdate
    // ファイルの登録
    //
}

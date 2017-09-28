package jp.co.isegorup.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Report")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportEntity {

    // PKは自動採番する。
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORTSEQ")
    @SequenceGenerator(name = "REPORTSEQ", sequenceName = "REPORTSEQ", allocationSize = 1)
    private Integer reportId;

    @Column(nullable = false)
    private Integer itemId;

    @Column(nullable = false)
    private String itemName;

    private String oelTwa;
    private String category;
    private Integer formulaImageId;

    private String itemSummary;

    private String hazardLoael;
    private String hazardTermsUf;
    private String hazardAnimalUf;

    private String pharmacokineticsLoael;
    private String pharmacokineticsTermsUf;
    private String pharmacokineticsAnimalUf;

    private String itemRemarks;
    private String notesSummary;
}

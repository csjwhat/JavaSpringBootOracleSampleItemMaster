CREATE TABLE REPORTS(
 report_id INT PRIMARY KEY,
 item_id INT,
 item_name VARCHAR(50),
 oel_twa VARCHAR(50),
 category VARCHAR(50),
 formula_image_id INT,
 item_summary NCLOB,
 hazard_loael VARCHAR(255),
 hazard_terms_uf VARCHAR(255),
 hazard_animal_uf VARCHAR(255),
 pharmacokinetics_loael VARCHAR(255),
 pharmacokinetics_terms_uf VARCHAR(255),
 pharmacokinetics_animal_uf VARCHAR(255),
 item_remarks NCLOB,
 notes_summary NCLOB,
 register_User VARCHAR(30),
 register_Date VARCHAR(50));

 CREATE SEQUENCE reportseq;
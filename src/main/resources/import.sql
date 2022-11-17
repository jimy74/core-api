SET schema 'public';

INSERT INTO vc_projects (pro_name) VALUES ('MissionFinder');
INSERT INTO vc_projects (pro_name) VALUES ('MyBlockTeacher');
INSERT INTO vc_projects (pro_name) VALUES ('Investis');

INSERT INTO vc_attributes (att_name, att_value, att_value_type) VALUES ('Description', 'This project is to help consultants to find missions consistently and quicker than in the traditional market', 0);
INSERT INTO vc_attributes (att_name, att_value, att_value_type) VALUES ('InitialBudgetCHF', '4000000', 1);
INSERT INTO vc_attributes (att_name, att_value, att_value_type) VALUES ('OurInternalProject', '0', 2);
INSERT INTO vc_attributes (att_name, att_value, att_value_type) VALUES ('PropositionDate', '2022-11-01', 3);

INSERT INTO vc_attributes (att_name, att_value, att_value_type) VALUES ('Description', 'This project is to provide formation around blockchain and IT architecture', 0);
INSERT INTO vc_attributes (att_name, att_value, att_value_type) VALUES ('InitialBudgetCHF', '400000', 1);
INSERT INTO vc_attributes (att_name, att_value, att_value_type) VALUES ('OurInternalProject', '1', 2);
INSERT INTO vc_attributes (att_name, att_value, att_value_type) VALUES ('PropositionDate', '2022-11-01', 3);

INSERT INTO vc_attributes (att_name, att_value, att_value_type) VALUES ('Description', 'This project is provide investment advises and trading plan', 0);
INSERT INTO vc_attributes (att_name, att_value, att_value_type) VALUES ('InitialBudgetCHF', '500000', 1);
INSERT INTO vc_attributes (att_name, att_value, att_value_type) VALUES ('PropositionDate', '2022-11-02', 3);


INSERT INTO vc_projects_attributes (project_pro_id, attributes_att_id) VALUES (1, 1);
INSERT INTO vc_projects_attributes (project_pro_id, attributes_att_id) VALUES (1, 2);
INSERT INTO vc_projects_attributes (project_pro_id, attributes_att_id) VALUES (1, 3);
INSERT INTO vc_projects_attributes (project_pro_id, attributes_att_id) VALUES (1, 4);

INSERT INTO vc_projects_attributes (project_pro_id, attributes_att_id) VALUES (2, 5);
INSERT INTO vc_projects_attributes (project_pro_id, attributes_att_id) VALUES (2, 6);
INSERT INTO vc_projects_attributes (project_pro_id, attributes_att_id) VALUES (2, 7);
INSERT INTO vc_projects_attributes (project_pro_id, attributes_att_id) VALUES (2, 8);

INSERT INTO vc_projects_attributes (project_pro_id, attributes_att_id) VALUES (3, 7);
INSERT INTO vc_projects_attributes (project_pro_id, attributes_att_id) VALUES (3, 9);
INSERT INTO vc_projects_attributes (project_pro_id, attributes_att_id) VALUES (3, 10);
INSERT INTO vc_projects_attributes (project_pro_id, attributes_att_id) VALUES (3, 11);






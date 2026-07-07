
-- Department, Employee, Skill Setup (Payroll)
CREATE TABLE IF NOT EXISTS department (
  dp_id INT AUTO_INCREMENT PRIMARY KEY,
  dp_name VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS employee (
  em_id INT AUTO_INCREMENT PRIMARY KEY,
  em_name VARCHAR(50),
  em_salary NUMERIC(10,2),
  em_permanent BOOLEAN,
  em_date_of_birth DATE,
  em_dp_id INT,
  FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);
CREATE TABLE IF NOT EXISTS skill (
  sk_id INT AUTO_INCREMENT PRIMARY KEY,
  sk_name VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS employee_skill (
  es_em_id INT,
  es_sk_id INT,
  PRIMARY KEY (es_em_id, es_sk_id),
  FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
  FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);
INSERT INTO department (dp_name) VALUES ('IT');
INSERT INTO department (dp_name) VALUES ('HR');
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES ('Alice', 50000, true, '1995-05-12', 1);
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES ('Charlie', 60000, true, '1993-01-12', 1);
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES ('Bob', 40000, false, '1996-06-20', 2);
INSERT INTO skill (sk_name) VALUES ('Java');
INSERT INTO skill (sk_name) VALUES ('SQL');
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);

-- Quiz Schema
CREATE TABLE IF NOT EXISTS quiz_user (
  us_id INT AUTO_INCREMENT PRIMARY KEY,
  us_name VARCHAR(50)
);
CREATE TABLE IF NOT EXISTS quiz_attempt (
  at_id INT AUTO_INCREMENT PRIMARY KEY,
  at_us_id INT,
  at_date DATE,
  FOREIGN KEY (at_us_id) REFERENCES quiz_user(us_id)
);
CREATE TABLE IF NOT EXISTS quiz_question (
  qn_id INT AUTO_INCREMENT PRIMARY KEY,
  qn_text VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS quiz_options (
  op_id INT AUTO_INCREMENT PRIMARY KEY,
  op_qn_id INT,
  op_text VARCHAR(100),
  op_score NUMERIC(5,2),
  op_correct BOOLEAN,
  FOREIGN KEY (op_qn_id) REFERENCES quiz_question(qn_id)
);
CREATE TABLE IF NOT EXISTS attempt_question (
  aq_id INT AUTO_INCREMENT PRIMARY KEY,
  aq_at_id INT,
  aq_qn_id INT,
  FOREIGN KEY (aq_at_id) REFERENCES quiz_attempt(at_id),
  FOREIGN KEY (aq_qn_id) REFERENCES quiz_question(qn_id)
);
CREATE TABLE IF NOT EXISTS attempt_option (
  ao_id INT AUTO_INCREMENT PRIMARY KEY,
  ao_aq_id INT,
  ao_op_id INT,
  ao_selected BOOLEAN,
  FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id),
  FOREIGN KEY (ao_op_id) REFERENCES quiz_options(op_id)
);

-- Seed Quiz Data
INSERT INTO quiz_user (us_name) VALUES ('John');
INSERT INTO quiz_attempt (at_us_id, at_date) VALUES (1, '2026-06-30');

INSERT INTO quiz_question (qn_text) VALUES ('What is the extension of the hyper text markup language file?');
INSERT INTO quiz_options (op_qn_id, op_text, op_score, op_correct) VALUES (1, '.xhtm', 0.0, false);
INSERT INTO quiz_options (op_qn_id, op_text, op_score, op_correct) VALUES (1, '.ht', 0.0, false);
INSERT INTO quiz_options (op_qn_id, op_text, op_score, op_correct) VALUES (1, '.html', 1.0, true);
INSERT INTO quiz_options (op_qn_id, op_text, op_score, op_correct) VALUES (1, '.htmx', 0.0, false);

INSERT INTO quiz_question (qn_text) VALUES ('What is the maximum level of heading tag can be used in a HTML page?');
INSERT INTO quiz_options (op_qn_id, op_text, op_score, op_correct) VALUES (2, '5', 0.0, false);
INSERT INTO quiz_options (op_qn_id, op_text, op_score, op_correct) VALUES (2, '3', 0.0, true);
INSERT INTO quiz_options (op_qn_id, op_text, op_score, op_correct) VALUES (2, '4', 0.0, false);
INSERT INTO quiz_options (op_qn_id, op_text, op_score, op_correct) VALUES (2, '6', 1.0, false);

-- Link attempts
INSERT INTO attempt_question (aq_at_id, aq_qn_id) VALUES (1, 1);
INSERT INTO attempt_question (aq_at_id, aq_qn_id) VALUES (1, 2);

INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (1, 1, false);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (1, 2, false);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (1, 3, true);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (1, 4, false);

INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (2, 5, false);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (2, 6, true);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (2, 7, false);
INSERT INTO attempt_option (ao_aq_id, ao_op_id, ao_selected) VALUES (2, 8, false);

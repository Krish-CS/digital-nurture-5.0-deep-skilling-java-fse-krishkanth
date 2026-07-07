
-- Country Setup
CREATE TABLE IF NOT EXISTS country (
  co_code VARCHAR(2) PRIMARY KEY,
  co_name VARCHAR(50)
);
INSERT INTO country (co_code, co_name) VALUES ('IN', 'India');
INSERT INTO country (co_code, co_name) VALUES ('US', 'United States');
INSERT INTO country (co_code, co_name) VALUES ('BV', 'Bouvet Island');
INSERT INTO country (co_code, co_name) VALUES ('DJ', 'Djibouti');
INSERT INTO country (co_code, co_name) VALUES ('GP', 'Guadeloupe');
INSERT INTO country (co_code, co_name) VALUES ('GS', 'South Georgia and the South Sandwich Islands');
INSERT INTO country (co_code, co_name) VALUES ('LU', 'Luxembourg');
INSERT INTO country (co_code, co_name) VALUES ('SS', 'South Sudan');
INSERT INTO country (co_code, co_name) VALUES ('TF', 'French Southern Territories');
INSERT INTO country (co_code, co_name) VALUES ('UM', 'United States Minor Outlying Islands');
INSERT INTO country (co_code, co_name) VALUES ('ZA', 'South Africa');
INSERT INTO country (co_code, co_name) VALUES ('ZM', 'Zambia');
INSERT INTO country (co_code, co_name) VALUES ('ZW', 'Zimbabwe');

-- Stock Setup
CREATE TABLE IF NOT EXISTS stock (
  st_id INT AUTO_INCREMENT PRIMARY KEY,
  st_code VARCHAR(10), 
  st_date DATE,
  st_open NUMERIC(10,2),
  st_close NUMERIC(10,2), 
  st_volume NUMERIC
);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-03', 184.00, 182.39, 9779400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-04', 184.65, 187.14, 11308000);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-22', 1236.67, 1253.76, 954200);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-23', 1256.64, 1270.59, 1593400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('NFLX', '2018-12-24', 242.00, 233.88, 9547600);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('NFLX', '2018-12-21', 263.83, 246.39, 21397600);

-- Payroll/Skill Setup
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
INSERT INTO employee (em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES ('Bob', 40000, false, '1996-06-20', 2);
INSERT INTO skill (sk_name) VALUES ('Java');
INSERT INTO skill (sk_name) VALUES ('SQL');
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);

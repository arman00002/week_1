CREATE TABLE country_language (
    country_code VARCHAR(2),
    language_id INT,
    PRIMARY KEY (country_code, language_id),
    FOREIGN KEY (country_code) REFERENCES country(co_code),
    FOREIGN KEY (language_id) REFERENCES language(id)
);
CREATE TABLE state (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  country_code VARCHAR(2),
  FOREIGN KEY (country_code) REFERENCES country(code)
);

CREATE TABLE language (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50)
);
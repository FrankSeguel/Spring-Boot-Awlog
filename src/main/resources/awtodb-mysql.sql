
CREATE TABLE awlog_hashtag (
                ID NUMERIC AUTO_INCREMENT NOT NULL,
                description VARCHAR(50) NOT NULL,
                PRIMARY KEY (ID)
);


CREATE TABLE awlog_logger (
                ID NUMERIC AUTO_INCREMENT NOT NULL,
                creation_date DATETIME NOT NULL,
                host VARCHAR(100) NOT NULL,
                origin VARCHAR(100) NOT NULL,
                details VARCHAR NOT NULL,
                stacktrace VARCHAR NOT NULL,
                PRIMARY KEY (ID)
);


CREATE TABLE awlog_logger_hashtag (
                id NUMERIC AUTO_INCREMENT NOT NULL,
                hastag_id NUMERIC NOT NULL,
                log_id NUMERIC NOT NULL,
                PRIMARY KEY (id)
);


ALTER TABLE awlog_logger_hashtag ADD CONSTRAINT awlog_hashtag_awlog_logger_hashtag_fk
FOREIGN KEY (hastag_id)
REFERENCES awlog_hashtag (ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE awlog_logger_hashtag ADD CONSTRAINT awlog_logger_awlog_logger_hashtag_fk
FOREIGN KEY (log_id)
REFERENCES awlog_logger (ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

CREATE SEQUENCE public.awlog_hashtag_id_seq;

CREATE TABLE public.awlog_hashtag (
                ID NUMERIC NOT NULL DEFAULT nextval('public.awlog_hashtag_id_seq'),
                description VARCHAR(50) NOT NULL,
                CONSTRAINT awlog_hashtag_pk PRIMARY KEY (ID)
);


ALTER SEQUENCE public.awlog_hashtag_id_seq OWNED BY public.awlog_hashtag.ID;

CREATE SEQUENCE public.awlog_logger_id_seq;

CREATE TABLE public.awlog_logger (
                ID NUMERIC NOT NULL DEFAULT nextval('public.awlog_logger_id_seq'),
                creation_date TIMESTAMP NOT NULL,
                host VARCHAR(100) NOT NULL,
                origin VARCHAR(100) NOT NULL,
                details VARCHAR NOT NULL,
                stacktrace VARCHAR NOT NULL,
                CONSTRAINT awlog_logger_pk PRIMARY KEY (ID)
);


ALTER SEQUENCE public.awlog_logger_id_seq OWNED BY public.awlog_logger.ID;

CREATE SEQUENCE public.awlog_logger_hashtag_id_seq;

CREATE TABLE public.awlog_logger_hashtag (
                id NUMERIC NOT NULL DEFAULT nextval('public.awlog_logger_hashtag_id_seq'),
                hastag_id NUMERIC NOT NULL,
                log_id NUMERIC NOT NULL,
                CONSTRAINT awlog_logger_hashtag_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.awlog_logger_hashtag_id_seq OWNED BY public.awlog_logger_hashtag.id;

ALTER TABLE public.awlog_logger_hashtag ADD CONSTRAINT awlog_hashtag_awlog_logger_hashtag_fk
FOREIGN KEY (hastag_id)
REFERENCES public.awlog_hashtag (ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.awlog_logger_hashtag ADD CONSTRAINT awlog_logger_awlog_logger_hashtag_fk
FOREIGN KEY (log_id)
REFERENCES public.awlog_logger (ID)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE awlog_logger_hashtag OWNER TO ownerawlog;
ALTER TABLE awlog_logger OWNER TO ownerawlog;
ALTER TABLE awlog_hashtag OWNER TO ownerawlog;

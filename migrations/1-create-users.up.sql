CREATE TABLE users (
  id         bigserial   PRIMARY KEY,
  username   varchar(30) NOT NULL UNIQUE,
  email      varchar(30) NOT NULL,
  locked     boolean     NOT NULL DEFAULT false,
  provider   varchar(20) NOT NULL, -- oauth provider, e.g. github
  uid        varchar(20) NOT NULL, -- the uid from oauth provider
  created_at timestamptz NOT NULL DEFAULT now(),
  UNIQUE(provider,uid)
);

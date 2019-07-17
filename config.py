import os


class Config:
    SQLALCHEMY_DATABASE_URI = os.environ.get('DATABASE_URL') \
                              or 'postgresql+psycopg2://together:g89id1@localhost:5432/go_together'
    SQLALCHEMY_TRACK_MODIFICATIONS = False
    SECRET_KEY = ''

import enum

from flask import url_for

from app import db
from werkzeug.security import generate_password_hash, check_password_hash


class OrderStatus(enum.Enum):
    created = 'Created'
    running = 'Running'
    done = 'Done'
    failure = 'Failure'


class EventPeopleStatus(enum.Enum):
    wait_for_accept = "Wait for accept"
    accepted = "Accepted"
    rejected = "Rejected"


class EventPrivacy(enum.Enum):
    all = "All"
    invited = "Invited"


class EventVisibility(enum.Enum):
    visible = "Visible"
    hidden = "Hidden"


class EventUsersPermissions(enum.Enum):
    admin = "Admin"
    moderator = "Moderator"
    member = "Member"


class UsersActivity(enum.Enum):
    active = "Active"
    disabled = "Disabled"


class Users(db.Model):
    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    username = db.Column(db.String(64), index=True, unique=True)
    email = db.Column(db.String(64), index=True, unique=True)
    password_hash = db.Column(db.String(256))
    isActive = db.Column(db.Enum(UsersActivity))

    def set_password(self, password):
        self.password_hash = generate_password_hash(password)

    def check_password(self, password):
        return check_password_hash(self.password_hash, password)

    def from_dict(self, data, new_user=False):
        for field in ['username', 'email', 'isActive']:
            if field in data:
                setattr(self, field, data[field])
            if new_user and 'password' in data:
                self.set_password(data['password'])

    def to_dict(self, include_email=False):
        data = {
            'id': self.id,
            'username': self.username,
            'isActive': self.isActive,
            '_links': {
                'self': url_for('api.get_user', id=self.id),
            }
        }
        if include_email:
            data['email'] = self.email
        return data


class Tokens(db.Model):
    token_id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    access_token = db.Column(db.String(256))
    refresh_token = db.Column(db.String(256))
    user_id = db.Column(db.Integer, db.ForeignKey('users.id'))
    start_date = db.Column(db.DateTime)
    end_date = db.Column(db.DateTime)
    isActive = db.Column(db.Boolean)


class Themes(db.Model):
    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    title = db.Column(db.String(64))


class Events(db.Model):
    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    name = db.Column(db.String)
    theme_id = db.Column(db.Integer, db.ForeignKey('themes.id'))
    location = db.Column(db.String)
    event_date = db.Column(db.DateTime)
    max_people = db.Column(db.Integer)
    owner_user_id = db.Column(db.Integer, db.ForeignKey('users.id'))
    visibility = db.Column(db.Enum(EventVisibility))
    privacy = db.Column(db.Enum(EventPrivacy))


class EventPeople(db.Model):
    id = db.Column(db.Integer, primary_key=True, autoincrement=True)
    event_id = db.Column(db.Integer, db.ForeignKey('events.id'))
    user_id = db.Column(db.Integer, db.ForeignKey('users.id'))
    is_go = db.Column(db.Enum(EventPeopleStatus))
    permission = db.Column(db.Enum(EventUsersPermissions))

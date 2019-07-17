from flask import request, jsonify, url_for

from app import db
from app.api import bp
from app.api.errors import bad_request
from app.models import Users


@bp.route('/users/<int:id_user>', methods=['GET'])
def get_user(id_user):
    return jsonify(Users.query.get_or_404(id_user).to_dict())


@bp.route('/user', methods=['POST'])
def create_user():
    data = request.get_json() or {}
    if 'username' not in data or 'email' not in data or 'password' not in data:
        return bad_request('must include username, email and password fields')
    if Users.query.filter_by(username=data['username']).first():
        return bad_request('Пожалуйста используйте другое имя пользователя.')
    if Users.query.filter_by(email=data['email']).first():
        return bad_request('Пожалуйста используйте другой e-mail для пользователя.')
    user = Users()
    user.from_dict(data, new_user=True)
    db.session.add(user)
    db.session.commit()
    response = jsonify(user.to_dict())
    response.status_code = 201
    response.headers['Location'] = url_for('api.get_user', id=user.id)
    return response

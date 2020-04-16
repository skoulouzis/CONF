# coding: utf-8

"""
    SEMAPHORE

    Semaphore API  # noqa: E501

    OpenAPI spec version: 2.2.0-oas3
    
    Generated by: https://github.com/swagger-api/swagger-codegen.git
"""

import pprint
import re  # noqa: F401

import six


class RepositoryRequest(object):
    """NOTE: This class is auto generated by the swagger code generator program.

    Do not edit the class manually.
    """
    """
    Attributes:
      swagger_types (dict): The key is attribute name
                            and the value is attribute type.
      attribute_map (dict): The key is attribute name
                            and the value is json key in definition.
    """
    swagger_types = {
        'name': 'str',
        'project_id': 'int',
        'git_url': 'str',
        'ssh_key_id': 'int'
    }

    attribute_map = {
        'name': 'name',
        'project_id': 'project_id',
        'git_url': 'git_url',
        'ssh_key_id': 'ssh_key_id'
    }

    def __init__(self, name=None, project_id=None, git_url=None, ssh_key_id=None):  # noqa: E501
        """RepositoryRequest - a model defined in Swagger"""  # noqa: E501
        self._name = None
        self._project_id = None
        self._git_url = None
        self._ssh_key_id = None
        self.discriminator = None
        if name is not None:
            self.name = name
        if project_id is not None:
            self.project_id = project_id
        if git_url is not None:
            self.git_url = git_url
        if ssh_key_id is not None:
            self.ssh_key_id = ssh_key_id

    @property
    def name(self):
        """Gets the name of this RepositoryRequest.  # noqa: E501


        :return: The name of this RepositoryRequest.  # noqa: E501
        :rtype: str
        """
        return self._name

    @name.setter
    def name(self, name):
        """Sets the name of this RepositoryRequest.


        :param name: The name of this RepositoryRequest.  # noqa: E501
        :type: str
        """

        self._name = name

    @property
    def project_id(self):
        """Gets the project_id of this RepositoryRequest.  # noqa: E501


        :return: The project_id of this RepositoryRequest.  # noqa: E501
        :rtype: int
        """
        return self._project_id

    @project_id.setter
    def project_id(self, project_id):
        """Sets the project_id of this RepositoryRequest.


        :param project_id: The project_id of this RepositoryRequest.  # noqa: E501
        :type: int
        """

        self._project_id = project_id

    @property
    def git_url(self):
        """Gets the git_url of this RepositoryRequest.  # noqa: E501


        :return: The git_url of this RepositoryRequest.  # noqa: E501
        :rtype: str
        """
        return self._git_url

    @git_url.setter
    def git_url(self, git_url):
        """Sets the git_url of this RepositoryRequest.


        :param git_url: The git_url of this RepositoryRequest.  # noqa: E501
        :type: str
        """

        self._git_url = git_url

    @property
    def ssh_key_id(self):
        """Gets the ssh_key_id of this RepositoryRequest.  # noqa: E501


        :return: The ssh_key_id of this RepositoryRequest.  # noqa: E501
        :rtype: int
        """
        return self._ssh_key_id

    @ssh_key_id.setter
    def ssh_key_id(self, ssh_key_id):
        """Sets the ssh_key_id of this RepositoryRequest.


        :param ssh_key_id: The ssh_key_id of this RepositoryRequest.  # noqa: E501
        :type: int
        """

        self._ssh_key_id = ssh_key_id

    def to_dict(self):
        """Returns the model properties as a dict"""
        result = {}

        for attr, _ in six.iteritems(self.swagger_types):
            value = getattr(self, attr)
            if isinstance(value, list):
                result[attr] = list(map(
                    lambda x: x.to_dict() if hasattr(x, "to_dict") else x,
                    value
                ))
            elif hasattr(value, "to_dict"):
                result[attr] = value.to_dict()
            elif isinstance(value, dict):
                result[attr] = dict(map(
                    lambda item: (item[0], item[1].to_dict())
                    if hasattr(item[1], "to_dict") else item,
                    value.items()
                ))
            else:
                result[attr] = value
        if issubclass(RepositoryRequest, dict):
            for key, value in self.items():
                result[key] = value

        return result

    def to_str(self):
        """Returns the string representation of the model"""
        return pprint.pformat(self.to_dict())

    def __repr__(self):
        """For `print` and `pprint`"""
        return self.to_str()

    def __eq__(self, other):
        """Returns true if both objects are equal"""
        if not isinstance(other, RepositoryRequest):
            return False

        return self.__dict__ == other.__dict__

    def __ne__(self, other):
        """Returns true if both objects are not equal"""
        return not self == other
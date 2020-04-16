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


class InventoryRequest(object):
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
        'inventory': 'str',
        'key_id': 'int',
        'ssh_key_id': 'int',
        'type': 'str'
    }

    attribute_map = {
        'name': 'name',
        'project_id': 'project_id',
        'inventory': 'inventory',
        'key_id': 'key_id',
        'ssh_key_id': 'ssh_key_id',
        'type': 'type'
    }

    def __init__(self, name=None, project_id=None, inventory=None, key_id=None, ssh_key_id=None, type=None):  # noqa: E501
        """InventoryRequest - a model defined in Swagger"""  # noqa: E501
        self._name = None
        self._project_id = None
        self._inventory = None
        self._key_id = None
        self._ssh_key_id = None
        self._type = None
        self.discriminator = None
        if name is not None:
            self.name = name
        if project_id is not None:
            self.project_id = project_id
        if inventory is not None:
            self.inventory = inventory
        if key_id is not None:
            self.key_id = key_id
        if ssh_key_id is not None:
            self.ssh_key_id = ssh_key_id
        if type is not None:
            self.type = type

    @property
    def name(self):
        """Gets the name of this InventoryRequest.  # noqa: E501


        :return: The name of this InventoryRequest.  # noqa: E501
        :rtype: str
        """
        return self._name

    @name.setter
    def name(self, name):
        """Sets the name of this InventoryRequest.


        :param name: The name of this InventoryRequest.  # noqa: E501
        :type: str
        """

        self._name = name

    @property
    def project_id(self):
        """Gets the project_id of this InventoryRequest.  # noqa: E501


        :return: The project_id of this InventoryRequest.  # noqa: E501
        :rtype: int
        """
        return self._project_id

    @project_id.setter
    def project_id(self, project_id):
        """Sets the project_id of this InventoryRequest.


        :param project_id: The project_id of this InventoryRequest.  # noqa: E501
        :type: int
        """

        self._project_id = project_id

    @property
    def inventory(self):
        """Gets the inventory of this InventoryRequest.  # noqa: E501


        :return: The inventory of this InventoryRequest.  # noqa: E501
        :rtype: str
        """
        return self._inventory

    @inventory.setter
    def inventory(self, inventory):
        """Sets the inventory of this InventoryRequest.


        :param inventory: The inventory of this InventoryRequest.  # noqa: E501
        :type: str
        """

        self._inventory = inventory

    @property
    def key_id(self):
        """Gets the key_id of this InventoryRequest.  # noqa: E501


        :return: The key_id of this InventoryRequest.  # noqa: E501
        :rtype: int
        """
        return self._key_id

    @key_id.setter
    def key_id(self, key_id):
        """Sets the key_id of this InventoryRequest.


        :param key_id: The key_id of this InventoryRequest.  # noqa: E501
        :type: int
        """

        self._key_id = key_id

    @property
    def ssh_key_id(self):
        """Gets the ssh_key_id of this InventoryRequest.  # noqa: E501


        :return: The ssh_key_id of this InventoryRequest.  # noqa: E501
        :rtype: int
        """
        return self._ssh_key_id

    @ssh_key_id.setter
    def ssh_key_id(self, ssh_key_id):
        """Sets the ssh_key_id of this InventoryRequest.


        :param ssh_key_id: The ssh_key_id of this InventoryRequest.  # noqa: E501
        :type: int
        """

        self._ssh_key_id = ssh_key_id

    @property
    def type(self):
        """Gets the type of this InventoryRequest.  # noqa: E501


        :return: The type of this InventoryRequest.  # noqa: E501
        :rtype: str
        """
        return self._type

    @type.setter
    def type(self, type):
        """Sets the type of this InventoryRequest.


        :param type: The type of this InventoryRequest.  # noqa: E501
        :type: str
        """
        allowed_values = ["static", "file"]  # noqa: E501
        if type not in allowed_values:
            raise ValueError(
                "Invalid value for `type` ({0}), must be one of {1}"  # noqa: E501
                .format(type, allowed_values)
            )

        self._type = type

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
        if issubclass(InventoryRequest, dict):
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
        if not isinstance(other, InventoryRequest):
            return False

        return self.__dict__ == other.__dict__

    def __ne__(self, other):
        """Returns true if both objects are not equal"""
        return not self == other
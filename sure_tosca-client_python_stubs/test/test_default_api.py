# coding: utf-8

"""
    tosca-sure

    TOSCA Simple qUeRy sErvice (SURE).   # noqa: E501

    OpenAPI spec version: 1.0.0
    Contact: S.Koulouzis@uva.nl
    Generated by: https://github.com/swagger-api/swagger-codegen.git
"""

from __future__ import absolute_import

import os
import unittest

import urllib3

import sure_tosca_client
from sure_tosca_client import Configuration, ApiClient
from sure_tosca_client.api.default_api import DefaultApi  # noqa: E501


class TestDefaultApi(unittest.TestCase):
    """DefaultApi unit test stubs"""

    def setUp(self):
        configuration = Configuration()
        configuration.host = 'http://127.0.0.1:8081/tosca-sure/1.0.0' #Make sure we don't have '/' on the end of url
        if self.service_is_up(configuration.host):
            configuration.verify_ssl = False
            api_client = ApiClient(configuration=configuration)
            self.api = sure_tosca_client.api.default_api.DefaultApi(api_client=api_client)  # noqa: E501
            self.service_is_up = True
        else:
            self.service_is_up = False

    def tearDown(self):
        pass

    def test_get_all_ancestor_properties(self):
        """Test case for get_all_ancestor_properties

          # noqa: E501
        """
        pass

    def test_get_all_ancestor_types(self):
        """Test case for get_all_ancestor_types

          # noqa: E501
        """
        pass

    def test_get_ancestors_requirements(self):
        """Test case for get_ancestors_requirements

          # noqa: E501
        """
        pass

    def test_get_dsl_definitions(self):
        """Test case for get_dsl_definitions

          # noqa: E501
        """
        pass

    def test_get_imports(self):
        """Test case for get_imports

          # noqa: E501
        """
        pass

    def test_get_node_outputs(self):
        """Test case for get_node_outputs

          # noqa: E501
        """
        pass

    def test_get_node_properties(self):
        """Test case for get_node_properties

          # noqa: E501
        """
        pass

    def test_get_node_requirements(self):
        """Test case for get_node_requirements

        """
        pass

    def test_get_node_templates(self):
        """Test case for get_node_templates

        """
        if self.service_is_up:
            file_id = self.upload_tosca_template('application_example_provisioned.yaml')
            node_templates = self.api.get_node_templates(file_id)
            self.assertIsNotNone(node_templates)
            nodes_to_deploy = self.api.get_node_templates(file_id,type_name = 'tosca.nodes.QC.Application')
        



    def test_get_node_type_name(self):
        """Test case for get_node_type_name

          # noqa: E501
        """
        pass

    def test_get_parent_type_name(self):
        """Test case for get_parent_type_name

          # noqa: E501
        """
        pass

    def test_get_related_nodes(self):
        """Test case for get_related_nodes

          # noqa: E501
        """
        pass

    def test_get_relationship_templates(self):
        """Test case for get_relationship_templates

          # noqa: E501
        """
        pass

    def test_get_topology_template(self):
        """Test case for get_topology_template

        """
        pass

    def test_get_tosca_template(self):
        """Test case for get_tosca_template

        """
        pass

    def test_get_types(self):
        """Test case for get_types

          # noqa: E501
        """
        pass

    def test_set_node_properties(self):
        """Test case for set_node_properties

          # noqa: E501
        """

        pass

    def test_upload_tosca_template(self):
        """Test case for upload_tosca_template

        upload a tosca template description file  # noqa: E501
        """
        if self.service_is_up:
            file_id = self.upload_tosca_template('application_example_provisioned.yaml')
            self.assertIsNotNone(file_id)

    def get_tosca_file(self, file_name):
        tosca_path = "../../TOSCA/"
        input_tosca_file_path = tosca_path + '/' + file_name
        if not os.path.exists(input_tosca_file_path):
            tosca_path = "../TOSCA/"
            input_tosca_file_path = tosca_path + '/' + file_name

        dir_path = os.path.dirname(os.path.realpath(__file__))
        self.assertEqual(True, os.path.exists(input_tosca_file_path),
                         'Starting from: ' + dir_path + ' Input TOSCA file: ' + input_tosca_file_path + ' not found')
        return input_tosca_file_path

    def upload_tosca_template(self, file_name):
        if self.service_is_up:
            file = self.get_tosca_file(file_name)
            file_id = self.api.upload_tosca_template(file)
            return file_id


    def service_is_up(self, url):
        code = None
        try:
            http = urllib3.PoolManager()
            r = http.request('HEAD', url)
        except Exception as e:
            return False

        return True

if __name__ == '__main__':
    unittest.main()

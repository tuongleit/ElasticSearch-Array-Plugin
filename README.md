# Introduction 
This plugin offers array format for REST search responses.

# Getting Started
This plugin provide the request format as belows:
> GET /_search_array
>
> POST /_search_array
> 
> GET /{index}/_search_array
> 
> POST /{index}/_search_array
> 
> GET /{index}/{type}/_search_array
>
> POST /{index}/{type}/_search_array
# Build and Test
1. Software dependencies 
   1. JAVA (jdk-17.0.1)
   2. Maven
   3. Elasticsearch (Window: https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.16.2-windows-x86_64.zip)

2. Installation process
   1. Build the compiled version of the Elasticsearch-plugin code, and to create a compiled version of it, run the following command:
      > $ mvn clean install
   2. Install the Elasticsearch-plugin

      Make the Elasticsearch (1.iii) directory your current working directory and run the following command:
      > $ ./cd bin
      > 
      > $ ./elasticsearch-plugin install file:/{path_to_project}/target/releases/elasticsearch-plugin-rs-1.0-SNAPSHOT.zip
   3. To check that the plugin is installed correctly in the elasticsearch, run the following command:
      > $ ./elasticsearch-plugin list

3. Run ElasticSearch
      > $ elasticsearch

4. Test the plugin

   To check that the plugin is working the way you want, run the Elasticsearch in your machine and run the following URL in the browser or Postman:
   > GET http://localhost:9200/_search_array
   
   The response should be:
   > [
        {\
      "study": "test study A",\
      "StudyUID": "1.2.4.5.5252",\
      "age": "12"\
      },
      {\
      "study": "test study B",\
      "StudyUID": "1.2.4.5.212",\
      "age": "12"\
      },
      {\
      "study": "test study C",\
      "StudyUID": "1.2.4.5.23512.23.125.125",\
      "age": "35"\
      }
      ]
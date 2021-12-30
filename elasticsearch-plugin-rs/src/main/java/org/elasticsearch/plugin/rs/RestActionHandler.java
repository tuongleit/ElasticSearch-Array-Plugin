package org.elasticsearch.plugin.rs;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.rest.*;
import org.elasticsearch.rest.action.search.RestSearchAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;

public class RestActionHandler implements RestHandler {

    @Override
    public void handleRequest(RestRequest request, RestChannel channel, NodeClient client) throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        IntConsumer setSize = (size) -> {
            searchRequest.source().size(size);
        };
        request.withContentOrSourceParamParserOrNull((parser) -> {
            RestSearchAction.parseSearchRequest(searchRequest, request, parser, client.getNamedWriteableRegistry(), setSize);
        });

        client.search(searchRequest, new RestResponseHandler(channel));
    }

    @Override
    // Declare all the routes here
    public List<Route> routes() {
        return new ArrayList<>(Arrays.asList(
                new Route(RestRequest.Method.GET, "/_search_array"),
                new Route(RestRequest.Method.POST, "/_search_array"),
                new Route(RestRequest.Method.GET, "/{index}/_search_array"),
                new Route(RestRequest.Method.POST, "/{index}/_search_array"),
                new Route(RestRequest.Method.GET, "/{index}/{type}/_search_array"),
                new Route(RestRequest.Method.POST, "/{index}/{type}/_search_array")
        ));
    }
}

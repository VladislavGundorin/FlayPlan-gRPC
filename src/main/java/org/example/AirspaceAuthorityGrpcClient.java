package org.example;

import airspace.AirspaceAuthorityOuterClass;
import airspace.AirspaceAuthorityServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AirspaceAuthorityGrpcClient {
    private final AirspaceAuthorityServiceGrpc.AirspaceAuthorityServiceBlockingStub stub;

    public AirspaceAuthorityGrpcClient(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub = AirspaceAuthorityServiceGrpc.newBlockingStub(channel);
    }

    public AirspaceAuthorityOuterClass.AirspaceAuthoritiesResponse getAirspaceAuthorities(AirspaceAuthorityOuterClass.AirspaceFilterRequest request) {
        return stub.getAirspaceAuthorities(request);
    }
}
package org.example;

import airspace.AirspaceAuthorityOuterClass;
import airspace.AirspaceAuthorityServiceGrpc;
import io.grpc.stub.StreamObserver;

public class AirspaceAuthorityGrpcServiceImpl extends AirspaceAuthorityServiceGrpc.AirspaceAuthorityServiceImplBase {

    private final AirspaceAuthorityGrpcClient grpcClient;

    public AirspaceAuthorityGrpcServiceImpl(AirspaceAuthorityGrpcClient grpcClient) {
        this.grpcClient = grpcClient;
    }

    @Override
    public void getAirspaceAuthorities(AirspaceAuthorityOuterClass.AirspaceFilterRequest request,
                                       StreamObserver<AirspaceAuthorityOuterClass.AirspaceAuthoritiesResponse> responseObserver) {
        try {
            AirspaceAuthorityOuterClass.AirspaceAuthoritiesResponse response = grpcClient.getAirspaceAuthorities(request);
            responseObserver.onNext(response);
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(e);
        } finally {
            responseObserver.onCompleted();
        }
    }
}

package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    public static void main(String[] args) throws Exception {
        AirspaceAuthorityGrpcClient grpcClient = new AirspaceAuthorityGrpcClient("localhost", 9091);

        Server server = ServerBuilder.forPort(9090)
                .addService(new AirspaceAuthorityGrpcServiceImpl(grpcClient))
                .build();

        System.out.println("FlayPlan-gRPC server started on port 9090...");
        server.start();
        server.awaitTermination();
    }
}

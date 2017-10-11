package io.grpc.examples;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.6.1)",
    comments = "Source: transport.proto")
public final class TransportServiceGrpc {

  private TransportServiceGrpc() {}

  public static final String SERVICE_NAME = "TransportService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.examples.Transport.InvoiceRequest,
      io.grpc.examples.Transport.InvoiceResponse> METHOD_ISSUE =
      io.grpc.MethodDescriptor.<io.grpc.examples.Transport.InvoiceRequest, io.grpc.examples.Transport.InvoiceResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "TransportService", "issue"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.examples.Transport.InvoiceRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.examples.Transport.InvoiceResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TransportServiceStub newStub(io.grpc.Channel channel) {
    return new TransportServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TransportServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TransportServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TransportServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TransportServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TransportServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void issue(io.grpc.examples.Transport.InvoiceRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.Transport.InvoiceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ISSUE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ISSUE,
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.Transport.InvoiceRequest,
                io.grpc.examples.Transport.InvoiceResponse>(
                  this, METHODID_ISSUE)))
          .build();
    }
  }

  /**
   */
  public static final class TransportServiceStub extends io.grpc.stub.AbstractStub<TransportServiceStub> {
    private TransportServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransportServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransportServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransportServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void issue(io.grpc.examples.Transport.InvoiceRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.Transport.InvoiceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ISSUE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TransportServiceBlockingStub extends io.grpc.stub.AbstractStub<TransportServiceBlockingStub> {
    private TransportServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransportServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransportServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransportServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public io.grpc.examples.Transport.InvoiceResponse issue(io.grpc.examples.Transport.InvoiceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ISSUE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TransportServiceFutureStub extends io.grpc.stub.AbstractStub<TransportServiceFutureStub> {
    private TransportServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TransportServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TransportServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TransportServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.Transport.InvoiceResponse> issue(
        io.grpc.examples.Transport.InvoiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ISSUE, getCallOptions()), request);
    }
  }

  private static final int METHODID_ISSUE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TransportServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TransportServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ISSUE:
          serviceImpl.issue((io.grpc.examples.Transport.InvoiceRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.Transport.InvoiceResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class TransportServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.Transport.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TransportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TransportServiceDescriptorSupplier())
              .addMethod(METHOD_ISSUE)
              .build();
        }
      }
    }
    return result;
  }
}

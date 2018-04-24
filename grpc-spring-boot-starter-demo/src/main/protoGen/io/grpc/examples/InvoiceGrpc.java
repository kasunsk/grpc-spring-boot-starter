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
    comments = "Source: invoice.proto")
public final class InvoiceGrpc {

  private InvoiceGrpc() {}

  public static final String SERVICE_NAME = "Invoice";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<io.grpc.examples.InvoiceOuterClass.InvoiceRequest,
      io.grpc.examples.InvoiceOuterClass.InvoiceResponse> METHOD_ISSUE_INVOICE =
      io.grpc.MethodDescriptor.<io.grpc.examples.InvoiceOuterClass.InvoiceRequest, io.grpc.examples.InvoiceOuterClass.InvoiceResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "Invoice", "issueInvoice"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.examples.InvoiceOuterClass.InvoiceRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              io.grpc.examples.InvoiceOuterClass.InvoiceResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InvoiceStub newStub(io.grpc.Channel channel) {
    return new InvoiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InvoiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new InvoiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InvoiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new InvoiceFutureStub(channel);
  }

  /**
   */
  public static abstract class InvoiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void issueInvoice(io.grpc.examples.InvoiceOuterClass.InvoiceRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.InvoiceOuterClass.InvoiceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ISSUE_INVOICE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ISSUE_INVOICE,
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.InvoiceOuterClass.InvoiceRequest,
                io.grpc.examples.InvoiceOuterClass.InvoiceResponse>(
                  this, METHODID_ISSUE_INVOICE)))
          .build();
    }
  }

  /**
   */
  public static final class InvoiceStub extends io.grpc.stub.AbstractStub<InvoiceStub> {
    private InvoiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InvoiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InvoiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InvoiceStub(channel, callOptions);
    }

    /**
     */
    public void issueInvoice(io.grpc.examples.InvoiceOuterClass.InvoiceRequest request,
        io.grpc.stub.StreamObserver<io.grpc.examples.InvoiceOuterClass.InvoiceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ISSUE_INVOICE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class InvoiceBlockingStub extends io.grpc.stub.AbstractStub<InvoiceBlockingStub> {
    private InvoiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InvoiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InvoiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InvoiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.examples.InvoiceOuterClass.InvoiceResponse issueInvoice(io.grpc.examples.InvoiceOuterClass.InvoiceRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ISSUE_INVOICE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class InvoiceFutureStub extends io.grpc.stub.AbstractStub<InvoiceFutureStub> {
    private InvoiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InvoiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InvoiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InvoiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.InvoiceOuterClass.InvoiceResponse> issueInvoice(
        io.grpc.examples.InvoiceOuterClass.InvoiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ISSUE_INVOICE, getCallOptions()), request);
    }
  }

  private static final int METHODID_ISSUE_INVOICE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InvoiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InvoiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ISSUE_INVOICE:
          serviceImpl.issueInvoice((io.grpc.examples.InvoiceOuterClass.InvoiceRequest) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.InvoiceOuterClass.InvoiceResponse>) responseObserver);
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

  private static final class InvoiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.InvoiceOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (InvoiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InvoiceDescriptorSupplier())
              .addMethod(METHOD_ISSUE_INVOICE)
              .build();
        }
      }
    }
    return result;
  }
}

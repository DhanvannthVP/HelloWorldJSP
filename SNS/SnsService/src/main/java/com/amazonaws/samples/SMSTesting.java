package com.amazonaws.samples;



	import com.amazonaws.auth.AWSCredentials;
	import com.amazonaws.auth.AWSStaticCredentialsProvider;
	import com.amazonaws.auth.BasicAWSCredentials;
	import com.amazonaws.regions.Regions;
	import com.amazonaws.services.sns.AmazonSNSClient;
	import com.amazonaws.services.sns.AmazonSNSClientBuilder;
	import com.amazonaws.services.sns.model.PublishRequest;
	import com.amazonaws.services.sns.model.PublishResult;

	public class SMSTesting {

	    private static AmazonSNSClient snsClient = null;
	 

	    public static int sendSMS(String message, String phoneNumber) {
	        try {
	        	
	            AWSCredentials credentials = null;
	    	
	            credentials = new BasicAWSCredentials(
	                        "AKIAI74J23KPDAA4IUNQ",
	                        "8VDKA9sliYA3PfMIS9V4y9YpyaIaUvPGNgEWMs6s");

	            snsClient = (AmazonSNSClient) AmazonSNSClientBuilder
	               	 .standard()
	               	 .withCredentials(new AWSStaticCredentialsProvider(credentials))
	               	 .withRegion(Regions.US_WEST_2).build();
	  
	            //boolean sendSms = validatePhoneNumber(phoneNumber);
	            PublishResult result = snsClient.publish(new PublishRequest()
	                    						.withMessage(message)
	                    						.withPhoneNumber(phoneNumber));
	            System.out.println("SMS is sent successfully. Message ID : " + result);

	        } catch (Exception e) {
	        	System.out.println("SMS Exception Message"+e);
	            return -1;
	        }
			return 0;
	    }
	    
	    public static void main (String args[]){
	    	
	    	sendSMS("Book you CAB.","+919941097424");
	    	
	    }
	    
	}


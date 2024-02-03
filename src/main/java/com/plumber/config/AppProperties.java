package com.plumber.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "app")
public class AppProperties {
	private final Auth auth = new Auth();
	private final OAuth2 oauth2 = new OAuth2();
	private final IskooluProps iskoolu = new IskooluProps();
	private final Payment payment = new Payment();
	private final AwsServices awsServices = new AwsServices();
	private final Admin admin = new Admin();
	private String domainUrl;

	public String getDomainUrl() {
		return domainUrl;
	}

	public void setDomainUrl(String domainUrl) {
		this.domainUrl = domainUrl;
	}

	public Admin getAdmin() {
		return admin;
	}

	public static class IskooluProps {
		private String firebaseConfigurationFile = null;
		private Map<String, String> notificationsDefaults = new HashMap<>();

		public String getFirebaseConfigurationFile() {
			return firebaseConfigurationFile;
		}

		public void setFirebaseConfigurationFile(String firebaseConfigurationFile) {
			this.firebaseConfigurationFile = firebaseConfigurationFile;
		}

		public Map<String, String> getNotificationsDefaults() {
			return notificationsDefaults;
		}

		public void setNotificationsDefaults(Map<String, String> notificationsDefaults) {
			this.notificationsDefaults = notificationsDefaults;
		}
	}

	public static class Auth {
		private String tokenSecret;
		private long tokenExpirationMsec;
		private String meetSecret;
		private long meetTokenExpirationMsec;

		public String getTokenSecret() {
			return tokenSecret;
		}

		public void setTokenSecret(String tokenSecret) {
			this.tokenSecret = tokenSecret;
		}

		public long getTokenExpirationMsec() {
			return tokenExpirationMsec;
		}

		public void setTokenExpirationMsec(long tokenExpirationMsec) {
			this.tokenExpirationMsec = tokenExpirationMsec;
		}

		public String getMeetSecret() {
			return meetSecret;
		}

		public void setMeetSecret(String meetSecret) {
			this.meetSecret = meetSecret;
		}

		public long getMeetTokenExpirationMsec() {
			return meetTokenExpirationMsec;
		}

		public void setMeetTokenExpirationMsec(long meetTokenExpirationMsec) {
			this.meetTokenExpirationMsec = meetTokenExpirationMsec;
		}
	}

	public static final class OAuth2 {
		private List<String> authorizedRedirectUris = new ArrayList<>();

		public List<String> getAuthorizedRedirectUris() {
			return authorizedRedirectUris;
		}

		public OAuth2 authorizedRedirectUris(List<String> authorizedRedirectUris) {
			this.authorizedRedirectUris = authorizedRedirectUris;
			return this;
		}
	}

	public static final class Payment {
		private GatewayProvider provider = new GatewayProvider();

		public static final class GatewayProvider {
			private Razorpay razorpay = new Razorpay();

			public final class Razorpay {
				
				private String key;
				private String secret;

				public String getKey() {
					return key;
				}

				public void setKey(String key) {
					this.key = key;
				}

				public String getSecret() {
					return secret;
				}

				public void setSecret(String secret) {
					this.secret = secret;
				}
			}

			public Razorpay getRazorpay() {
				return razorpay;
			}
		}

		public GatewayProvider getProvider() {
			return provider;
		}

		public void setProvider(GatewayProvider provider) {
			this.provider = provider;
		}
	}

	public static class AwsServices {

		private String bucketName;
		private String url;

		public String getBucketName() {
			return bucketName;
		}

		public void setBucketName(String bucketName) {
			this.bucketName = bucketName;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}

	public Auth getAuth() {
		return auth;
	}

	public OAuth2 getOauth2() {
		return oauth2;
	}

	public IskooluProps getIskoolu() {
		return iskoolu;
	}

	public Payment getPayment() {
		return payment;
	}

	public AwsServices getAwsServices() {
		return awsServices;
	}

	public static class Admin {
		private String userIds;

		public String getUserIds() {
			return userIds;
		}

		public void setUserIds(String userIds) {
			this.userIds = userIds;
		}
	}
}

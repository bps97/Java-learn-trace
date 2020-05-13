
FROM java:8
ADD ssm-heam-1.0.jar ssm-heam-1.0
RUN bash -c 'touch /ssm-heam-1.0.jar'
ENTRYPOINT [ "java","-jar","/ssm-heam-1.0.jar"]
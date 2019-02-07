FROM python:3.7.2-stretch

RUN pip install kafka-python confluent-kafka

COPY . /app/

CMD ["python", "/app/[[ .Component ]].py"]
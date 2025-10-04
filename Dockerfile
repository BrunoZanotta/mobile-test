FROM --platform=linux/amd64 ghcr.io/cirruslabs/android-sdk:33

ENV DEBIAN_FRONTEND=noninteractive \
    ANDROID_SDK_ROOT=/opt/android-sdk \
    ANDROID_HOME=/opt/android-sdk \
    PATH="$PATH:/opt/android-sdk/cmdline-tools/latest/bin:/opt/android-sdk/platform-tools"

RUN apt-get update && apt-get install -y --no-install-recommends \
      curl wget unzip git python3 make g++ maven ca-certificates gnupg && \
    curl -fsSL https://deb.nodesource.com/setup_20.x | bash - && \
    apt-get install -y --no-install-recommends nodejs && \
    rm -rf /var/lib/apt/lists/*

RUN npm i -g appium@latest appium-uiautomator2-driver@latest

RUN mkdir -p /opt/android-sdk/cmdline-tools && \
    wget -q https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip -O /tmp/clt.zip && \
    unzip -q /tmp/clt.zip -d /opt/android-sdk/cmdline-tools && \
    rm -f /tmp/clt.zip && \
    mv /opt/android-sdk/cmdline-tools/cmdline-tools /opt/android-sdk/cmdline-tools/latest && \
    yes | sdkmanager --licenses && \
    sdkmanager "platform-tools" "platforms;android-33" "build-tools;33.0.2"


WORKDIR /src

COPY pom.xml ./
RUN --mount=type=cache,target=/root/.m2 \
    mvn -B -Dmaven.artifact.threads=8 dependency:go-offline

COPY . .

EXPOSE 4723

CMD ["mvn", "clean", "test"]
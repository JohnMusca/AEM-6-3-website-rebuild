# AEM-6-3-website-rebuild

#URL:
author:
http://localhost:4602

# Deploy:
mvn clean install -PautoInstallPackage  -Padobe-public
-- core / bundles:
mvn clean install -PautoInstallBundle -Padobe-public

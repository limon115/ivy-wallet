import os
import re

gradle_file = "shared/ui/core/build.gradle.kts"
kt_file = "shared/ui/core/src/main/java/com/ivy/design/system/IvyTypography.kt"

try:
    # 1. Extract the true namespace
    with open(gradle_file, "r") as f:
        gradle_content = f.read()
    
    namespace_match = re.search(r'namespace\s*=\s*["\'](.*?)["\']', gradle_content)
    if not namespace_match:
        print("❌ Could not find namespace in build.gradle.kts!")
        exit(1)
        
    real_namespace = namespace_match.group(1)
    print(f"✅ Found true module namespace: {real_namespace}")
    
    # 2. Read the Typography file
    with open(kt_file, "r") as f:
        kt_content = f.read()
        
    # 3. Surgically swap the import
    bad_import = "import com.ivy.ui.core.R"
    good_import = f"import {real_namespace}.R"
    
    if bad_import in kt_content:
        kt_content = kt_content.replace(bad_import, good_import)
        with open(kt_file, "w") as f:
            f.write(kt_content)
        print(f"✅ SURGICAL REPAIR SUCCESSFUL: Injected '{good_import}'")
    else:
        print("⚠️ Bad import not found. It may have already been altered.")
        
except Exception as e:
    print(f"❌ Error during surgical repair: {e}")
